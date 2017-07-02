Console based application that prompts for user input and produces output based on the problem and rules outlined below:

Problem:
You are in your house wearing pajamas. You must be appropriately dressed for the temperature before leaving your house.
Your challenge is to programmatically process a list of commands for getting ready, enforce related rules, and display appropriate output.

Inputs:
1.	Temperature Type (one of the following)
    •	HOT
    •	COLD
2.	Comma separated list of numeric commands

Rules:
•	Initial state is in your house with your pajamas on
•	Pajamas must be taken off before anything else can be put on
•	Only 1 piece of each type of clothing may be put on
•	You cannot put on socks when it is hot
•	You cannot put on a jacket when it is hot
•	Socks must be put on before shoes
•	Pants must be put on before shoes
•	The shirt must be put on before the headwear or jacket
•	You cannot leave the house until all items of clothing are on (except socks and a jacket when it’s hot)
•	If an invalid command is issued, respond with “fail” and stop processing commands
