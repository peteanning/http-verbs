/*
 * Copyright 2022 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.play.http.ws.default

import uk.gov.hmrc.http.{CoreGet, GetHttpTransport, HttpResponse}
import uk.gov.hmrc.play.http.ws.{WSExecute, WSHttpResponse, WSRequestBuilder}

import scala.concurrent.{ExecutionContext, Future}

trait WSGet extends CoreGet with GetHttpTransport with WSRequestBuilder with WSExecute {

  override def doGet(
    url: String,
    headers: Seq[(String, String)]
  )(
    implicit ec: ExecutionContext
  ): Future[HttpResponse] =
    execute(buildRequest(url, headers), "GET")
      .map(WSHttpResponse.apply)
}
