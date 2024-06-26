package com.jpa.hibernate.app.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="Course")
@NamedQueries(value = {
    @NamedQuery(name="query_get_all_courses", query="select c from Course c"),
    @NamedQuery(name="query_get_java_courses", query="select c from Course c where name like '%JAVA%'")
})
public class Course {
  @Id
  @GeneratedValue
  private Long id;
  @Column(name="name", nullable = false)
  private String name;

  @UpdateTimestamp
  private LocalDateTime lastUpdatedDate;

  @CreationTimestamp
  private LocalDateTime createDate;

  public Course() {

  }

  public Course(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Course{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
