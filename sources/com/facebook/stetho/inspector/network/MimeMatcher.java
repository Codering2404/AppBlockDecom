package com.facebook.stetho.inspector.network;

import java.util.ArrayList;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MimeMatcher<T> {
    private final ArrayList<MimeMatcher<T>.MimeMatcherRule> mRuleMap = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class MimeMatcherRule {
        private final boolean mHasWildcard;
        private final String mMatchPrefix;
        private final T mResultIfMatched;

        public MimeMatcherRule(String str, T t2) {
            if (str.endsWith("*")) {
                this.mHasWildcard = true;
                this.mMatchPrefix = str.substring(0, str.length() - 1);
            } else {
                this.mHasWildcard = false;
                this.mMatchPrefix = str;
            }
            if (!this.mMatchPrefix.contains("*")) {
                this.mResultIfMatched = t2;
                return;
            }
            throw new IllegalArgumentException("Multiple wildcards present in rule expression " + str);
        }

        public T getResultIfMatched() {
            return this.mResultIfMatched;
        }

        public boolean match(String str) {
            if (str.startsWith(this.mMatchPrefix)) {
                return this.mHasWildcard || str.length() == this.mMatchPrefix.length();
            }
            return false;
        }
    }

    public void addRule(String str, T t2) {
        this.mRuleMap.add(new MimeMatcherRule(str, t2));
    }

    public void clear() {
        this.mRuleMap.clear();
    }

    @Nullable
    public T match(String str) {
        int size = this.mRuleMap.size();
        for (int i3 = 0; i3 < size; i3++) {
            MimeMatcher<T>.MimeMatcherRule mimeMatcherRule = this.mRuleMap.get(i3);
            if (mimeMatcherRule.match(str)) {
                return mimeMatcherRule.getResultIfMatched();
            }
        }
        return null;
    }
}
