package GameObjects;

import Annotations.FieldAnnotation;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
@FieldAnnotation
public class FieldConstructor implements Serializable {
    private int length = 20;
    private int height = 10;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Cell[][] initF() throws IOException {
        int id = 0;
        Cell[][]cells = new Cell[length][height];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell();
                cells[i][j].setId(id);
                id++;
            }
        }
        return cells;
    }
}
