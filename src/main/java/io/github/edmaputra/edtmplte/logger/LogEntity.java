package io.github.edmaputra.edtmplte.logger;

public class LogEntity {

    private String layer;

    private String entity;

    private String message;

    public LogEntity() {
    }

    public LogEntity(String entity, String message) {
        this.entity = entity;
        this.message = message;
    }

    public LogEntity(String layer, String entity, String message) {
        this.layer = layer;
        this.entity = entity;
        this.message = message;
    }

    @Override
    public String toString() {
        return "LogEntity{" +
                "layer='" + layer + '\'' +
                ", entity='" + entity + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
