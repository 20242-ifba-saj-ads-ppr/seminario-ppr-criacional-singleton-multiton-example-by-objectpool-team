package clipboard_singleton;

class XmlDiagram {

    private String xmlDiagram = "";

    public XmlDiagram(String xmlDiagram) {
        this.xmlDiagram = xmlDiagram;
    }

    public ImageDiagram toImage() {
        return new ImageDiagram("image format " + xmlDiagram);
    }

    @Override
    public String toString() {
        return xmlDiagram;
    }
}