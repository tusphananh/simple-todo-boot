package com.example.demo.entities;

import io.leangen.graphql.annotations.GraphQLQuery;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GraphQLQuery(name = "id", description = "Unique ID of the Todo")
    private Long id;

    @Column(nullable = false)
    @GraphQLQuery(name = "title", description = "Title of the Todo")
    private String title;

    @Column(length = 1000)
    @GraphQLQuery(name = "description", description = "Description of the Todo")
    private String description;

    @Column(name = "due_date")
    @GraphQLQuery(name = "dueDate", description = "Due Date of the Todo")
    private LocalDateTime dueDate;

    @Column(nullable = false)
    @GraphQLQuery(name = "completed", description = "Status of the Todo")
    private boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @GraphQLQuery(name = "user", description = "The User who owns the Todo")
    private User user;

}