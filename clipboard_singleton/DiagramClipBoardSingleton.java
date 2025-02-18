// Elaborado pela equipe ObjectPoolSingleton
// 
// Clipboard tambem conhecido como area de transferencia é uma funcionalidade 
// dos sistemas operacionais que permite que programas armazenem e recuperem informações
//  de uma area de armazenamento compartilhada entre diferentes programas.

// Porpulamente os programas implementam os atalhos Ctrl+C para copiar e Ctrl+V para colar,

// Imagine um cenario em que um programa deseja que ao copiar algo nele,
// o conteudo que sera colado dependa do alvo da colagem
// Por exemplo, um editor de diagramas deseja que voce possa copiar e colar diagramas nele mesmo,
// mas que ao colar em outro programa, seja colada uma imagem

// Para isso podemos implementar uma classe que:
// Ao copiarmos um diagrama, armazene internamente como xml e na clipboard do SO armazene como uma imagem

// Ao colar, caso o conteudo da clipboard seja uma iamgem,
//  verificar se ela corresponde a imagem do diagrama armazenado como xml internamente, caso seja, colar o xml.

package clipboard_singleton;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.util.Optional;

public class DiagramClipBoardSingleton {
    private static DiagramClipBoardSingleton instance;

    private XmlDiagram xmlDiagram; 

    private DiagramClipBoardSingleton() {
    }

    public static synchronized DiagramClipBoardSingleton getInstance() {
        if (instance == null) {
            instance = new DiagramClipBoardSingleton();
        }
        return instance;
    }


    public Optional<String> paste() {

        String clipboardContent = getClipboardContent();

        if (clipboardContent == null) {
            return Optional.empty();
        }

        ImageDiagram i = new ImageDiagram(clipboardContent);

        if (xmlDiagram != null && this.xmlDiagram.toImage().equals(i)) {
            
            Optional<String> o = Optional.of(this.xmlDiagram.toString());
            
            return o;
        }

        return Optional.empty();

    }


    public void copy(String textToCopy) {

        this.xmlDiagram = new XmlDiagram(textToCopy);

        ImageDiagram i = this.xmlDiagram.toImage();

        setClipboardContent(i.toString());
    }

    private String getClipboardContent() {
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            Transferable contents = clipboard.getContents(null);

            if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return (String) contents.getTransferData(DataFlavor.stringFlavor);
            }

        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setClipboardContent(String content) {

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        
        StringSelection selection = new StringSelection(content);
        
        clipboard.setContents(selection, null);
    }
}
