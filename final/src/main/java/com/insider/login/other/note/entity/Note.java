package com.insider.login.other.note.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "note")
@AllArgsConstructor
@Getter
@ToString
public class Note {

    @Id
    @Column(name = "NOTE_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteNo;

    @Column(name = "SEND_NOTE_DATE", nullable = false)
    private String sendNoteDate;

    @Column(name = "NOTE_TITLE", nullable = false)
    private String noteTitle;

    @Column(name = "NOTE_CONTENT", nullable = false)
    private String noteContent;

    @Column(name = "SENDER_ID", nullable = false)
    private int senderId;    // 사번

    @Column(name = "RECEIVER_ID", nullable = false)
    private int receiverId;  // 사번

    @Column(name = "DELETE_YN", nullable = false)
    private String deleteYn; // 디폴트 값으로 "N"을 할당



    public Note() {

    }



}
