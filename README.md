# DiscountStepCalculateSample
This project's for implements in Object Oriented Programming by using Java Language that How to calculate product discount step by range of buying amount.

Example
========
- Assume product have unit price is 120 THB (Thai Baht)
- When you buy between 101 pcs to 200 pcs, You have got discount 5 THB / pcs
- When you buy between 201 pcs to 300 pcs, You have got discount 5 THB / pcs
- When you buy between 301 pcs to 400 pcs, You have got discount 5 THB / pcs
- If you buy this product 400 pcs, How many of total discount?

SOLUTIONS
==========
- assume discountStep = 5, productPrice = 120
- totalDiscount = (((OrderAmount - 1) / 100) * discountStep) * productPrice
