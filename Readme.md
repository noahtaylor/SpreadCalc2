# Coding Challenge

In completion of this task I utilized Java and created a small application which can be run using the Main class.  I chose this technology as it is what I am most comfortable in using to complete this task.

## Technical Choices and Trade-Offs

### Spread calculation as a service
In both problems I chose to read the inputs from csv files for simplicity and so both problems could reuse the input generation code.  The csv files exist on the file system and are statically defined within the main method.  Given more time, the application would act more as a service where files and spreads could processed/uploaded on demand.

### Output generation
Output is simply generated to a console and in a production environment you would want to output to a proper log file or remote logging system

### Testing of invalid input
Although I did do unit tests and my code handles bad input, my coverage does avoid situations where the input files were incorrectly defined as the challenge specs indicated we could make assumptions about the input being valid.  Given more time I would cover these situations also.  

### Exception handling
In most situations where there is an issue an expection is thrown which results in the application terminating.  Given more time I would make the application more robust in handling exceptions and handle these situations more elegantly

### Use of big decimal
For precision sake I used the BigDecimal class for yields and maturity.  The positive side of this is you avoid floating point precision issues, the negative is the code is a bit harder to read and there is higher computation time.  Considering the small number of computations speed was considered a non issue and accuracy more important.



