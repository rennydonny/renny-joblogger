package com.renny.joblogger.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by renrodriguez on 5/3/2016.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoggerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String message;

    @Column
    private String name;
}
