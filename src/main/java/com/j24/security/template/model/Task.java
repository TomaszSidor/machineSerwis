package com.j24.security.template.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @CreationTimestamp
    private LocalDateTime timeAdded;
    private LocalDateTime timeStarted;

    private LocalDateTime timeFinished;

    @Enumerated(value = EnumType.STRING)
    private TaskStatus taskStatus;
    @Enumerated(value = EnumType.STRING)
    private TaskProgressStatus taskProgressStatus;

    @ManyToOne()
    private Machine machine;
    @ManyToOne()
    private Account owner;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "task")
    private List<Comment> comments;


}


