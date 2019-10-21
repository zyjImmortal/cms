package com.zyj.cms.core.service.book.spring.chapter1.di;

public class BraveKnight implements Knight{

    private Quest quest;
    public BraveKnight(Quest quest){
        this.quest = quest;
    }

    public void embarkOnQuest(){
        this.quest.embark();
    }
}
