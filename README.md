# random-data-generation-application

This is an API project that provides fictional data to simulate bank queries.

### Configuration

Before you can use the system, you need to perform some settings. Below are the instructions:

First you need to build the application. To do this, inside the project folder execute:

`gradle clean build`

Also mount the Docker image. To do this, run:

`docker build -t [image name]: [tag] .`

Now you just need to run. Run:
 
`docker run -p 8080: 8080 [image name]: [tag]`

Ready!

### How to use

you must inform the **customer id**, **year** and **month** in which you want to consult the bank statement

`[GET] /<id>/transacoes/<year>/<month>`

this will return a json with this structure:

`[
  {
     "descricao": "string"
     "data": "long(timestamp)"
     "valor": "integer"
     "duplicated": "boolean"
  }  
]`