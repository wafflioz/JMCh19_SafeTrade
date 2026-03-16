# SafeTrade TODO Checklist

## ✅ Core backend
- [ ] Implement `Stock` constructor, `placeOrder(...)`, `executeOrders()`, and `getQuote()`
- [ ] Implement `StockExchange` constructor + `listStock()`, `getQuote()`, and `placeOrder()`
- [ ] Verify `PriceComparator` sorts market orders ahead of limit and correctly handles cents rounding

## ✅ Brokerage & User Management
- [ ] Implement `Brokerage` constructor and storage (`TreeMap` + `TreeSet`)
- [ ] Implement `addUser()` with validation and error codes
- [ ] Implement `login()` and `logout()` behavior, including message buffering
- [ ] Implement `getQuote(symbol, trader)` to forward quote messages
- [ ] Implement `placeOrder(order)` to forward orders to the exchange

## ✅ Testing (MyTests_*)
- [ ] Add coverage tests for `Stock` (matching, partial fills, quote formatting)
- [ ] Add coverage tests for `StockExchange` (listing, quote not found, order routing)
- [ ] Add coverage tests for `PriceComparator` (market vs limit, ascending vs descending)
- [ ] Add coverage tests for `Brokerage` (registration/login errors, message buffering, quote/order forwarding)
- [ ] Run `make` and verify coverage report is generated successfully

## ✅ End-to-end validation
- [ ] Run the UI and confirm:
  - traders can register and login
  - quotes display correctly for listed and unlisted symbols
  - orders execute and generate proper trader messages
  - messages persist when logging out and back in
