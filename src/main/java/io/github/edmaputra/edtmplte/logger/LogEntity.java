package io.github.edmaputra.edtmplte.logger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
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
}
