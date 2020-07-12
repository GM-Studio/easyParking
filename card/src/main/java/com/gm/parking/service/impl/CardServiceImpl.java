package com.gm.parking.service.impl;

import com.gm.parking.entity.Card;
import com.gm.parking.mapper.CardMapper;
import com.gm.parking.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CardServiceImpl implements CardService {


    @Autowired
    private CardMapper cardMapper;

    @Override
    public boolean saveCard(Card card) {
        return cardMapper.saveCard(card);
    }

    @Override
    public boolean updateCard(Card card) {
        return cardMapper.updateCard(card);
    }

    @Override
    public boolean deleteCard(int id) {
        return cardMapper.deleteCard(id);
    }

    @Override
    public Card cardById(int id) {
        return cardMapper.cardById(id);
    }

    @Override
    public List<Card> cardList() {
        return cardMapper.cardList();
    }
}
