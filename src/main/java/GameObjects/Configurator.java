package GameObjects;

import GameObjects.Livings.*;
import Interfaces.GameObject;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.*;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Configurator {
    private  GameField gameField;
    private Avatar avatar;
    private  int id = 0;
    private  final String[]livingNames = {"Bear.YML", "Boa.YML","Boar.YML", "Buffalo.YML", "Deer.YML",
            "Duck.YML", "Eagle.YML", "Fox.YML", "Goat.YML", "Grass.YML", "Horse.YML", "Mouse.YML", "Rabbit.YML",
            "Sheep.YML", "Wolf.YML", "Worm.YML"};
    private  final Class[]clazzes = {Bear.class, Boa.class, Boar.class, Buffalo.class, Deer.class,
    Duck.class, Eagle.class, Fox.class, Goat.class, Grass.class, Horse.class, Mouse.class,
    Rabbit.class, Sheep.class, Wolf.class, Worm.class};
    private final Property property = new Property();
    public Cell[][] crateYmlFiles() throws IOException {

        ObjectMapper mapper = new YAMLMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);


        GameObject[]livings = {new Bear(), new Boa(), new Boar(), new Buffalo(), new Deer(), new Duck(),
        new Eagle(), new Fox(), new Goat(), new Grass(), new Horse(), new Mouse(), new Rabbit(),
        new Sheep(), new Wolf(), new Worm()};

        for (int i = 0; i < livings.length; i++) {
            String name = "src/main/resources/YMLfiles/Livings/" + livingNames[i];
            YamlWriter yamlWriter = new YamlWriter(new FileWriter(name));
            yamlWriter.write(mapper.writeValueAsString(livings[i]));
            yamlWriter.close();
        }

        String name = "src/main/resources/YMLfiles/GameObjectsFiles/FieldConstructor.YML";
        YamlWriter yamlWriter = new YamlWriter(new FileWriter(name));
        yamlWriter.write(mapper.writeValueAsString(new FieldConstructor()));
        yamlWriter.close();


        return new Cell[0][];
    }
    public  GameObject createGameObjectsFromYML(int choice) throws IOException {
        String path = "src/main/resources/YMLfiles/Livings/";
        File file = new File(path + livingNames[choice]);
        ObjectMapper mapper = new YAMLMapper();
        YamlReader yamlReader = new YamlReader(new FileReader(file));
        String copyString = (String) yamlReader.read();
        GameObject gameObject = (GameObject)mapper.readValue(copyString,clazzes[choice]);
        gameObject.setId(id);
        id++;
        yamlReader.close();
        return gameObject;
    }
    public  FieldConstructor createGameFieldFromYML() throws IOException{
        String path = "src/main/resources/YMLfiles/GameObjectsFiles/FieldConstructor.YML";
        File file = new File(path);
        ObjectMapper mapper = new YAMLMapper();
        YamlReader yamlReader = new YamlReader(new FileReader(file));
        String copyString = (String) yamlReader.read();
        FieldConstructor constructor = (FieldConstructor) mapper.readValue(copyString, FieldConstructor.class);
        yamlReader.close();
        return constructor;
    }

    public  GameField initGameField() throws IOException, InterruptedException {
        int x = 0;
        int y = 0;
        avatar = new Avatar();
        gameField = new GameField();
        Random random = new Random();
        Cell[][] cells = createGameFieldFromYML().initF();
        for (Cell[] C:cells) {
            for (Cell CELL:C) {
                ArrayBlockingQueue<GameObject> queue = CELL.getQueue();
                for (int i = 0; i < random.nextInt(1, CELL.getCapacity()); i++) {
                    GameObject object = createGameObjectsFromYML(random.nextInt(1, livingNames.length));
                    if(testCell(queue, object)) {
                        object.getCoordinate().setCoordinate(x, y);
                        object.setProperty(property.getMap(object.getTypes()));
                        object.setAvatar(avatar.getAvatarStrings(object.getTypes()));
                        object.setGameField(gameField);
                        queue.put(object);
                        gameField.setCounterMap(object.getTypes(), object.getId());
                    }
                }
                x++;
            }
            x = 0;
            y++;
        }
          gameField.setGameField(cells);
          return gameField;
    }
    public  int getCounter(Types types){
        return gameField.getCount(types);
    }
    public boolean testCell(ArrayBlockingQueue<GameObject> queue, GameObject object){
        int quantity = (int)queue.stream().filter(c->c.getTypes().equals(object.getTypes())).count();
        if(quantity < object.getMaxQuantity()){
            return true;
        }
        else {
            return false;
        }
    }
}
