package caixa.dto;

import java.math.BigDecimal;

import caixa.domain.CardType;
import caixa.domain.PaymentType;

public class PaymentDTO {
	CardType cardType;
	PaymentType paymentType;
	BigDecimal value;

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
