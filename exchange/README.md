# 환전 서비스

## 요구사항

- 지갑에 있는 돈을 다른 화폐로 환전할 수 있어야 한다.
- 환전할 수 있는 외화는 다음과 같다.
  - 달러
  - 엔화
  - 유로
  - 위안
  - TBD...
- 환율은 실시간으로 변동될 수 있다.
- 환전할 금액이 0보다 크고 지갑에 있는 금액보다 작을 경우 환전할 수 있다.
- 환전할 금액이 지갑에 있는 금액보다 많을 경우 환전할 수 없다.
- 환전할 금액이 0보다 작을 경우 환전할 수 없다.
- 환전한 금액은 지갑에 추가된다.
- 추후 마이크로 서비스 아키텍처를 적용하여 지갑 서비스와 연계될 것을 고려한다.
  - 지갑에 원화를 충전하는 것은 이 서비스에서 다루지 않는다.
- 환전 서비스는 다른 서비스와 독립적으로 동작할 수 있어야 한다.
- 환전 결과 소수점인 경우 반올림하여 적용한다.
  - e.g. 1400.5원 > 1401원
  - e.g. 1400.4원 > 1400원

## 용어(with ChatGPT)

### 💰 기본적인 변수명
- baseCurrency (기본 통화, 예: KRW)
- targetCurrency (환전할 외화, 예: USD)
- exchangeRate (환율)
- amount (환전할 금액)
- convertedAmount (환전 후 금액)
- fee (수수료)
- totalAmount (총 지불 금액, 환전 금액 + 수수료)

### 🏦 추가적인 개념
- walletBalance (지갑 잔액)
- exchangeProvider (환전 제공자, 은행 or 환전소)
- transactionId (환전 거래 ID)
- timestamp (거래 시간)
- minExchangeAmount (최소 환전 가능 금액)
- maxExchangeAmount (최대 환전 가능 금액)

### ✨ 추가 기능 고려
- userTier (사용자 등급, VIP 여부에 따라 수수료 달라질 수도)
- discountRate (할인율, 특정 조건에서 수수료 할인)
- exchangeMode (AUTO vs MANUAL, 자동 환전 여부)
- exchangeStatus (PENDING, COMPLETED, FAILED)
