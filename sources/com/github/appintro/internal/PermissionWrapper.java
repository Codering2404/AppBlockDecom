package com.github.appintro.internal;

import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class PermissionWrapper implements Serializable {
    private String[] permissions;
    private int position;
    private boolean required;

    public PermissionWrapper(String[] permissions, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.permissions = permissions;
        this.position = i3;
        this.required = z2;
    }

    public static /* synthetic */ PermissionWrapper copy$default(PermissionWrapper permissionWrapper, String[] strArr, int i3, boolean z2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            strArr = permissionWrapper.permissions;
        }
        if ((i4 & 2) != 0) {
            i3 = permissionWrapper.position;
        }
        if ((i4 & 4) != 0) {
            z2 = permissionWrapper.required;
        }
        return permissionWrapper.copy(strArr, i3, z2);
    }

    public final String[] component1() {
        return this.permissions;
    }

    public final int component2() {
        return this.position;
    }

    public final boolean component3() {
        return this.required;
    }

    public final PermissionWrapper copy(String[] permissions, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        return new PermissionWrapper(permissions, i3, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(PermissionWrapper.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.github.appintro.internal.PermissionWrapper");
        }
        PermissionWrapper permissionWrapper = (PermissionWrapper) obj;
        return Arrays.equals(this.permissions, permissionWrapper.permissions) && this.position == permissionWrapper.position && this.required == permissionWrapper.required;
    }

    public final String[] getPermissions() {
        return this.permissions;
    }

    public final int getPosition() {
        return this.position;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.permissions) * 31) + this.position) * 31) + Boolean.valueOf(this.required).hashCode();
    }

    public final void setPermissions(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.permissions = strArr;
    }

    public final void setPosition(int i3) {
        this.position = i3;
    }

    public final void setRequired(boolean z2) {
        this.required = z2;
    }

    public String toString() {
        return "PermissionWrapper(permissions=" + Arrays.toString(this.permissions) + ", position=" + this.position + ", required=" + this.required + ")";
    }

    public /* synthetic */ PermissionWrapper(String[] strArr, int i3, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(strArr, i3, (i4 & 4) != 0 ? true : z2);
    }
}
