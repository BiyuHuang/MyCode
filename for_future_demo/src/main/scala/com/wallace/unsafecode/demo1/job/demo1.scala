package com.wallace.unsafecode.demo1.job

import java.util.Date

import com.wallace.unsafecode.demo1.service.Counter
import com.wallace.common.LogSupport
import com.wallace.utils.TimePara

/**
 * Created by Wallace on 2016/1/7.
 */
object demo1 extends App with LogSupport {
  val myCounter = new Counter


  log.info(s"[${new Date(System.currentTimeMillis()).toString}]" +
    s"${TimePara.getCurrentDate} " +
    s"The current value: ${myCounter.current}")
  while (myCounter.current <= 10) {
    myCounter.increment()
  }
  log.info(s"[${new Date(System.currentTimeMillis()).toString}]" +
    s"Now,the current value: ${myCounter.current}")
  log.info(s"[${new Date(System.currentTimeMillis()).toString}]" +
    s"[Excute time]${TimePara.getCurrentDate}")

  val person = new Person
  if (person.getClass == classOf[Person]) {
    person.getInfo
    log.info(s"[${new Date(System.currentTimeMillis()).toString}]" +
      "person 是Person类的对象，但不是其子类")
  }
  val man = new Man
  if (man.isInstanceOf[Person]) {

    man.getInfo
    log.info(s"[${new Date(System.currentTimeMillis()).toString}]" +
      "Man 是Person类的一个对象，也是其子类！")
  }
}

class Person {
  protected var name: String = null

  protected def setName(n: String): Unit = {
    this.name = n
  }

  protected def getName: String = {
    this.name
  }

  def getInfo: Unit = {
    println("Person's name is " + s"${this.getName}")
  }
}

class Man extends Person {
  setName("Wallace Huang")
}