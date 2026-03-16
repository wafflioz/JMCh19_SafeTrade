# SafeTrade TODO Checklist (Prioritized by Dependencies)

## 1. ✅ PriceComparator (Foundation)
- [ ] Verify `PriceComparator` sorts market orders ahead of limit and correctly handles cents rounding

## 2. ✅ Stock (Depends on PriceComparator)
- [ ] Implement `Stock` constructor, `placeOrder(...)`, `executeOrders()`, and `getQuote()`

## 3. ✅ StockExchange (Depends on Stock)
- [ ] Implement `StockExchange` constructor + `listStock()`, `getQuote()`, and `placeOrder()`

## 4. ✅ Brokerage & User Management (Depends on StockExchange)
- [ ] Implement `Brokerage` constructor and storage (`TreeMap` + `TreeSet`)
- [ ] Implement `addUser()` with validation and error codes
- [ ] Implement `login()` and `logout()` behavior, including message buffering
- [ ] Implement `getQuote(symbol, trader)` to forward quote messages
- [ ] Implement `placeOrder(order)` to forward orders to the exchange

## 5. ✅ Testing (MyTests_* — After Implementation)
- [ ] Add coverage tests for `PriceComparator` (market vs limit, ascending vs descending)
- [ ] Add coverage tests for `Stock` (matching, partial fills, quote formatting)
- [ ] Add coverage tests for `StockExchange` (listing, quote not found, order routing)
- [ ] Add coverage tests for `Brokerage` (registration/login errors, message buffering, quote/order forwarding)
- [ ] Run `make` and verify coverage report is generated successfully

## 6. ✅ End-to-end validation (Final Step)
- [ ] Run the UI and confirm:
  - traders can register and login
  - quotes display correctly for listed and unlisted symbols
  - orders execute and generate proper trader messages
  - messages persist when logging out and back in
