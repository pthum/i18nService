/**
 * Copyright (C) 2012 the original author or authors.
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

package controllers;

import com.google.common.base.Optional;
import com.google.inject.Inject;

import models.Error;
import models.Message;
import ninja.Context;
import ninja.Result;
import ninja.Results;
import ninja.i18n.Messages;
import ninja.params.Params;
import ninja.params.PathParam;

public class ApiController
{
    @Inject
    Messages msg;

    public Result getMessageWithParamsJson(@PathParam("key") String key, Context ctx,
                                           @Params(value = "params") String[] params)
    {
        Result result = Results.json();
        Optional<Result> optResult = Optional.of(result);

        Optional<String> message = msg.get(key, ctx, optResult, params);
        if (message.isPresent() == false)
        {
            return result.render(new Error(msg.get("error.notFound", ctx, optResult, key).get()));
        }
        return result.render(new Message(key, message.get()));
    }

    public Result getCatchAllOther(Context ctx)
    {
        Result result = Results.json();
        Optional<Result> optResult = Optional.of(result);

        return result.render(new Error(msg.get("error.catchAll", ctx, optResult).get()));

    }
}
