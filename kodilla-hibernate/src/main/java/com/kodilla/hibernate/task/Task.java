package com.kodilla.hibernate.task;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "TASKS")
public class Task {
    private int id;
    private String description;
    private Date created;
    private int duration;
    private TaskFinancialDetails taskFinancialDetails;

    public Task() {
    }

    /**
     * Submodule 13.2. Task.
     *
     * @param description description
     * @param duration    duration
     */
    public Task(final String description, final int duration) {
        this.description = description;
        this.created = new Date();
        this.duration = duration;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @NotNull
    @Column(name = "CREATED")
    public Date getCreated() {
        return created;
    }

    @Column(name = "DURATION")
    public int getDuration() {
        return duration;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TASKS_FINANCIALS_ID")
    public TaskFinancialDetails getTaskFinancialDetails() {
        return taskFinancialDetails;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setCreated(final Date created) {
        this.created = created;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public void setTaskFinancialDetails(final TaskFinancialDetails taskFinancialDetails) {
        this.taskFinancialDetails = taskFinancialDetails;
    }
}
