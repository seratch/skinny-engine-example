package app

import skinny.test.scalatest.SkinnyFlatSpec

class HelloSpec extends SkinnyFlatSpec {
  addServlet(app.Hello, "/hello/*")

  it should "work fine with GET Requests" in {
    get("/hello") {
      status should equal(200)
      body should equal("Hello, Anonymous")
    }
    get("/hello?name=Martin") {
      status should equal(200)
      body should equal("Hello, Martin")
    }
  }

  it should "work fine with POST Requests" in {
    post("/hello", Map()) {
      status should equal(200)
      body should equal("Hello, Anonymous")
    }
    post("/hello", Map("name" -> "Martin")) {
      status should equal(200)
      body should equal("Hello, Martin")
    }
  }

  it should "work fine with AsyncResult" in {
    get("/hello/async") {
      status should equal(200)
      body should equal("Hello, Anonymous")
    }
    get("/hello/async?name=Martin") {
      status should equal(200)
      body should equal("Hello, Martin")
    }
  }
}
