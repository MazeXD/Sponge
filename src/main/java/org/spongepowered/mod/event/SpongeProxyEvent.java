/**
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.mod.event;

import cpw.mods.fml.common.eventhandler.Event;

public class SpongeProxyEvent extends Event {

    private final org.spongepowered.api.event.Event event;

    public SpongeProxyEvent(org.spongepowered.api.event.Event event) {
        this.event = event;
    }

    @Override
    public boolean isCancelable() {
        return event.isCancellable();
    }

    @Override
    public boolean isCanceled() {
        return event.isCancelled();
    }

    @Override
    public void setCanceled(boolean cancel) {
        event.setCancelled(cancel);
    }

    @Override
    public boolean hasResult() {
        return event.getResult() != org.spongepowered.api.event.Result.NO_RESULT;
    }

    @Override
    public Result getResult() {
        final org.spongepowered.api.event.Result result = event.getResult();

        switch (result) {
            case ALLOW:
                return Result.ALLOW;
            case DENY:
                return Result.DENY;
            default:
                return Result.DEFAULT;
        }
    }

    @Override
    public void setResult(Result value) {
        switch (value) {
            case ALLOW:
                event.setResult(org.spongepowered.api.event.Result.ALLOW);
                break;
            case DENY:
                event.setResult(org.spongepowered.api.event.Result.DENY);
                break;
            default:
                event.setResult(org.spongepowered.api.event.Result.DEFAULT);
        }
    }
}
