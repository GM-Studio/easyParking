package com.gm.parking.service;

import com.gm.parking.entity.Card;

import java.util.List;

public interface CardService {

    public boolean saveCard(Card card);
    public boolean updateCard(Card card);
    public boolean deleteCard(int id);
    public Card cardById(int id);
    public List<Card> cardList();

}



