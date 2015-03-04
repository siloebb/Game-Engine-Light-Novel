
package br.silo.engine.vs.audio;

/**
 *
 * @author Siloé
 */
public class Audio {
    private String nameFull;
    private String name;
    private String extension;

    public Audio(String name) {
        this.nameFull = name;
    }

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        String[] split = nameFull.split(".");
        name = split[0];
        extension = split[1];
        this.nameFull = nameFull;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        nameFull = nameFull.replaceFirst(this.name, "");
        nameFull = name + "" + nameFull;
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        nameFull = nameFull.replace(this.extension, "");
        nameFull = nameFull + "" + extension;
        this.extension = extension;
    }
}
