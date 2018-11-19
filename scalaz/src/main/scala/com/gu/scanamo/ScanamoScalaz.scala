package com.gu.scanamo

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync
import com.gu.scanamo.ops.{ScalazInterpreter, ScanamoOps}
import scalaz.ioeffect.Task
import shims._

object ScanamoScalaz {

  def exec[A](client: AmazonDynamoDBAsync)(op: ScanamoOps[A]): Task[A] =
    op.asScalaz.foldMap(ScalazInterpreter.io(client))

}
