package app;

import Model.ArbolHuffman;
import Model.Nodo;
import Util.Contador;
import Util.HuffmanDecoder;
import Util.TraductorASCII;
import Util.BinarioAASCII;
import Util.ASCIIABinario;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. Leer archivo
            String texto = new String(
                    Files.readAllBytes(
                            Paths.get("ProgramaHuffman/src/GREEN EGGS AND HAM.txt")
                    )
            );

            System.out.println("Texto original:");
            System.out.println(texto);

            // 2. Contar frecuencias
            Contador contador = new Contador();
            Map<Character, Integer> frecuencias = contador.contar(texto);

            // 3. Construir árbol
            ArbolHuffman arbol = new ArbolHuffman();
            Nodo raiz = arbol.construir(texto);

            // 4. Generar códigos
            Map<Character, String> codigos = arbol.generarCodigos(raiz);

            // 5. Codificar
            TraductorASCII traductor = new TraductorASCII();
            String codificado = traductor.codificar(texto, codigos);

            System.out.println("\nTexto codificado:");
            System.out.println(codificado);

            // 6. Crear decoder (ANTES de usarlo)
            HuffmanDecoder decoder = new HuffmanDecoder();

            // 7. Convertir binario → ASCII
            BinarioAASCII conversor = new BinarioAASCII();
            String ascii = conversor.binarioAAscii(codificado);

            System.out.println("\nTexto en ASCII:");
            System.out.println(ascii);

            // 8. ASCII → binario
            ASCIIABinario reverso = new ASCIIABinario();
            String binarioRecuperado = reverso.asciiABinario(ascii);

            // 9. Decodificar desde ASCII
            String decodificadoASCII = decoder.decodificar(binarioRecuperado, raiz);

            System.out.println("\nTexto decodificado desde ASCII:");
            System.out.println(decodificadoASCII);

            // 10. Decodificación directa (original)
            String decodificado = decoder.decodificar(codificado, raiz);

            System.out.println("\nTexto decodificado:");
            System.out.println(decodificado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}