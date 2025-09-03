# Custom Sorting Scenario-Based Interview Questions  
*(Java — Team Lead Level)*

This document contains advanced scenario-based sorting questions for Java interviews, focusing on custom comparators, business logic, and system design.

---

## 🔹 1. Sort products by price in ascending order

**Question:**  
Given a list of products, how would you sort them by price (lowest to highest)?

---

## 🔹 2. Sort products by category, then by price (ascending)

**Question:**  
How would you group products by category and sort each group by price?

---

## 🔹 3. Sort products by name alphabetically (case-insensitive)

**Question:**  
Some product names may have mixed casing. Sort all products alphabetically, ignoring case.

---

## 🔹 4. Sort products by price descending, but break ties by name ascending

**Question:**  
If two products have the same price, how do you make sure the cheaper one comes first alphabetically?

---

## 🔹 5. Sort products with null categories last

**Question:**  
Some products might not have a category set. Sort by category, but keep nulls at the bottom.

---

## 🔹 6. Sort products that belong to category "sports" first, then sort the rest by price ascending

**Question:**  
How would you sort a list where items of a certain category have priority?

---

## 🔹 7. Sort products by the length of product name

**Question:**  
Sort all products so that those with shorter names appear before longer names.

---

## 🔹 8. Sort by price, but ignore any products priced 0 or less

**Question:**  
Skip invalid (free or negative) products and sort the rest by price.

---

## 🔹 9. Sort a large list of products (millions) efficiently. What would you consider?

**Question:**  
What would you do to optimize performance when sorting millions of product entries by price?

---

## 🔹 10. How would you sort products using Java Streams API?

**Question:**  
Can you sort a list of products using Java 8+ Streams in a functional style?

---

## 🔹 11. Sort products by category with a custom order: 'Book', 'sports', 'drawing', then others

**Question:**  
You want a custom order for category values — how do you apply this custom logic?

---

## 🔹 12. Write a generic method to sort any list of products based on a passed comparator

**Question:**  
How would you design a reusable method that accepts a list and a sort rule (comparator)?

---

## 🔹 13. Sort a product list loaded from DB, where some prices are null

**Question:**  
Some prices are not yet populated. Sort by price, but keep nulls at the end.

---

## 🔹 14. How do you sort products stored in a Map<Integer, Product> by product name?

**Question:**  
Product list is stored as a map. How would you sort it by product name?

---

## 🔹 15. You receive product data as a List<String[]>, where each element is a CSV row. How do you sort by price?

**Question:**  
Given CSV-style input, how do you sort it based on a specific column like price?

---

## 🔹 16. Sort products based on a complex business rule

**Question:**  
How do you build a comparator based on business logic like:  
→ if price > 1000 and category = Book, rank higher?

---

## 🔹 17. What's the difference between Comparable and Comparator when sorting products?

**Question:**  
Which approach would you use when you need multiple sorting strategies?

---

## 🔹 18. If two products are equal based on sorting logic, will their original order be preserved?

**Question:**  
Is Java's sort stable? Can it guarantee that equal elements retain their order?

---

## 🔹 19. You want to sort but avoid modifying the original list. How?

**Question:**  
How can you return a sorted version of a product list without changing the original?

---

## 🔹 20. Sort dynamically based on frontend input: field and order

**Question:**  
Design a backend service where sort field (e.g., name, price) and order (asc/desc) are passed as parameters.

---

## 🧠 Bonus — System Design / High-Level Questions

### 🔸 21. How would you design a product search + sort API for a large catalog?

Include pagination, filtering, sorting, performance considerations.

---

### 🔸 22. How do you manage dynamic sorting in a microservice setup?

Client wants sorting flexibility — how do you implement reusable sorting in backend services?

---

### 🔸 23. If sorting logic becomes more complex over time, how would you refactor your comparators?

Would you use Strategy Pattern, Enum-based comparators, or some config-driven approach?

---

### 🔸 24. What would you consider while sorting in-memory vs database level?

Which one is more performant in what scenarios?

---

### 🔸 25. How would you unit test different sorting strategies?

What would your test