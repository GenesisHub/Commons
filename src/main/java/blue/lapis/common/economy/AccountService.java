/*
 * LapisCommons
 * Copyright (c) 2014, Lapis <https://github.com/LapisBlue>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package blue.lapis.common.economy;

import com.google.common.collect.ImmutableSet;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface AccountService {


    @Nullable
    ImmutableSet<EconomyAccount> getAccounts(@Nonnull Object owner);

    @Nullable
    EconomyAccount getAccount(@Nonnull Object owner, @Nonnull String accountName);

    @Nonnull
    EconomyAccount createAccount(@Nonnull Object owner, @Nonnull String accountName);


    // getAccount(owner, getDefaultAccountName())
    @Nullable
    EconomyAccount getDefaultAccount(@Nonnull Object owner) throws EconomyDefaultAccountNotSupported;


    // createDefaultAccount(owner, getDefaultAccountName())
    @Nonnull
    EconomyAccount createDefaultAccount(@Nonnull Object owner) throws EconomyDefaultAccountNotSupported;

    // syntax sugar and for performance optimization

    @Nonnull
    String getDefaultAccountName(@Nonnull Object owner) throws EconomyDefaultAccountNotSupported;

    @Nullable
    ImmutableSet<String> getAccountNames(@Nonnull Object owner);

    boolean hasAccount(@Nonnull Object owner, @Nonnull String accountName);

    boolean hasDefaultAccount(@Nonnull Object owner) throws EconomyDefaultAccountNotSupported;

    @Nonnull
    EconomyAccount getOrCreateAccount(@Nonnull Object owner, String accountName) throws EconomyDefaultAccountNotSupported;

    @Nonnull
    EconomyAccount getOrCreateDefaultAccount(@Nonnull Object owner) throws EconomyDefaultAccountNotSupported;
}
