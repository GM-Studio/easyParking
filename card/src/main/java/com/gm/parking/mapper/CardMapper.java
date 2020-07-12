package com.gm.parking.mapper;

import com.gm.parking.entity.Card;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CardMapper {

    public boolean saveCard(Card card);
    public boolean updateCard(Card card);
    public boolean deleteCard(int id);
    public Card cardById(int id);
    public List<Card> cardList();
}
