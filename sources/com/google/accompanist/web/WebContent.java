package com.google.accompanist.web;

import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public abstract class WebContent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Data extends WebContent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f68880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f68881b;

        public final String b() {
            return this.f68881b;
        }

        public final String c() {
            return this.f68880a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return Intrinsics.areEqual(this.f68880a, data.f68880a) && Intrinsics.areEqual(this.f68881b, data.f68881b);
        }

        public int hashCode() {
            int iHashCode = this.f68880a.hashCode() * 31;
            String str = this.f68881b;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Data(data=" + this.f68880a + ", baseUrl=" + this.f68881b + ')';
        }
    }

    public /* synthetic */ WebContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final String a() {
        if (this instanceof Url) {
            return ((Url) this).e();
        }
        if (this instanceof Data) {
            return ((Data) this).b();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Url extends WebContent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f68882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f68883b;

        public /* synthetic */ Url(String str, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? MapsKt.emptyMap() : map);
        }

        public static /* synthetic */ Url c(Url url, String str, Map map, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = url.f68882a;
            }
            if ((i3 & 2) != 0) {
                map = url.f68883b;
            }
            return url.b(str, map);
        }

        public final Url b(String url, Map additionalHttpHeaders) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(additionalHttpHeaders, "additionalHttpHeaders");
            return new Url(url, additionalHttpHeaders);
        }

        public final Map d() {
            return this.f68883b;
        }

        public final String e() {
            return this.f68882a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Url)) {
                return false;
            }
            Url url = (Url) obj;
            return Intrinsics.areEqual(this.f68882a, url.f68882a) && Intrinsics.areEqual(this.f68883b, url.f68883b);
        }

        public int hashCode() {
            return (this.f68882a.hashCode() * 31) + this.f68883b.hashCode();
        }

        public String toString() {
            return "Url(url=" + this.f68882a + ", additionalHttpHeaders=" + this.f68883b + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Url(String url, Map additionalHttpHeaders) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(additionalHttpHeaders, "additionalHttpHeaders");
            this.f68882a = url;
            this.f68883b = additionalHttpHeaders;
        }
    }

    private WebContent() {
    }
}
