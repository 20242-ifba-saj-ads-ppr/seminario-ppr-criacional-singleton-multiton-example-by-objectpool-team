package clipboard_singleton;

class ImageDiagram {
    
    private String imageDiagram = "";

    public ImageDiagram(String imageDiagram) {
        this.imageDiagram = imageDiagram;
    }

    public boolean equals(ImageDiagram obj) {
    
        return this.imageDiagram.equals(obj.imageDiagram);
        
    }

    @Override
    public String toString(){
        return imageDiagram;
    }

}
