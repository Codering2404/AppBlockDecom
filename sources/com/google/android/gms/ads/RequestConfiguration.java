package com.google.android.gms.ads;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RequestConfiguration {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List f69678f = Arrays.asList("MA", "T", "PG", "G");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f69679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f69680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f69681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f69682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PublisherPrivacyPersonalizationState f69683e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f69684a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f69685b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f69686c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f69687d = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private PublisherPrivacyPersonalizationState f69688e = PublisherPrivacyPersonalizationState.DEFAULT;

        public RequestConfiguration a() {
            return new RequestConfiguration(this.f69684a, this.f69685b, this.f69686c, this.f69687d, this.f69688e, null);
        }

        public Builder b(List list) {
            List list2 = this.f69687d;
            list2.clear();
            if (list != null) {
                list2.addAll(list);
            }
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface MaxAdContentRating {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum PublisherPrivacyPersonalizationState {
        DEFAULT(0),
        ENABLED(1),
        DISABLED(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f69693a;

        PublisherPrivacyPersonalizationState(int i3) {
            this.f69693a = i3;
        }

        public int a() {
            return this.f69693a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForChildDirectedTreatment {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForUnderAgeOfConsent {
    }

    /* synthetic */ RequestConfiguration(int i3, int i4, String str, List list, PublisherPrivacyPersonalizationState publisherPrivacyPersonalizationState, byte[] bArr) {
        this.f69679a = i3;
        this.f69680b = i4;
        this.f69681c = str;
        this.f69682d = list;
        this.f69683e = publisherPrivacyPersonalizationState;
    }

    public String a() {
        String str = this.f69681c;
        return str == null ? "" : str;
    }

    public PublisherPrivacyPersonalizationState b() {
        return this.f69683e;
    }

    public int c() {
        return this.f69679a;
    }

    public int d() {
        return this.f69680b;
    }

    public List e() {
        return new ArrayList(this.f69682d);
    }
}
