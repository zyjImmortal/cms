package com.zyj.cms.core.service.book.spring.chapter1.di;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest(){
        Quest quest = mock(Quest.class); // mock一个Quest对象
        BraveKnight knight = new BraveKnight(quest);
        knight.embarkOnQuest();
        verify(quest, times(1)); // 确认只被调用一次
    }
}
