package com.sleepkqq.sololeveling.player.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "levels")
public class Level {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Version
  private int version;

  private int level;

  private int totalExperience;

  private int currentExperience;

  private int experienceToNextLevel;

  private double coefficient;

  @CreationTimestamp
  @Column(updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @OneToOne
  @JoinColumn(name = "player_id")
  private Player player;

  @OneToOne
  @JoinColumn(name = "player_task_topic_id")
  private PlayerTaskTopic playerTaskTopic;
}
