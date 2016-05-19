package com.renny.joblogger.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by renrodriguez on 5/3/2016.
 */
@Entity
@Data
public class LoggerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String message;

    @Column
    private String name;
}
