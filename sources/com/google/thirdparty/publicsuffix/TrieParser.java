package com.google.thirdparty.publicsuffix;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Queues;
import java.util.Deque;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class TrieParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Joiner f91555a = Joiner.i("");

    private static int a(Deque deque, CharSequence charSequence, int i3, ImmutableMap.Builder builder) {
        int length = charSequence.length();
        char cCharAt = 0;
        int i4 = i3;
        while (i4 < length && (cCharAt = charSequence.charAt(i4)) != '&' && cCharAt != '?' && cCharAt != '!' && cCharAt != ':' && cCharAt != ',') {
            i4++;
        }
        deque.push(d(charSequence.subSequence(i3, i4)));
        if (cCharAt == '!' || cCharAt == '?' || cCharAt == ':' || cCharAt == ',') {
            String strE = f91555a.e(deque);
            if (strE.length() > 0) {
                builder.g(strE, PublicSuffixType.b(cCharAt));
            }
        }
        int iA = i4 + 1;
        if (cCharAt != '?' && cCharAt != ',') {
            while (iA < length) {
                iA += a(deque, charSequence, iA, builder);
                if (charSequence.charAt(iA) == '?' || charSequence.charAt(iA) == ',') {
                    iA++;
                    break;
                }
            }
        }
        deque.pop();
        return iA - i3;
    }

    static ImmutableMap b(String str) {
        ImmutableMap.Builder builderA = ImmutableMap.a();
        int length = str.length();
        int iA = 0;
        while (iA < length) {
            iA += a(Queues.a(), str, iA, builderA);
        }
        return builderA.d();
    }

    static ImmutableMap c(CharSequence... charSequenceArr) {
        return b(f91555a.g(charSequenceArr));
    }

    private static CharSequence d(CharSequence charSequence) {
        return new StringBuilder(charSequence).reverse();
    }
}
