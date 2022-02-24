package com.floresbarco.analyzer;

import java.io.File;
import java.io.IOException;

public class Generate {
    public void generateFlex() throws IOException, Exception{
        String ruta1 = "/home/jafb/IdeaProjects/OCL1_201801287_P1/src/com/floresbarco/analyzer/Lexer.flex";
        File archivo;

        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
    }
}
