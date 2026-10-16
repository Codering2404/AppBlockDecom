package com.applovin.exoplayer2.common.base;

import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Preconditions {
    private Preconditions() {
    }

    private static String badElementIndex(int i3, int i4, @NullableDecl String str) {
        if (i3 < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i3));
        }
        if (i4 >= 0) {
            return Strings.lenientFormat("%s (%s) must be less than size (%s)", str, Integer.valueOf(i3), Integer.valueOf(i4));
        }
        throw new IllegalArgumentException("negative size: " + i4);
    }

    private static String badPositionIndex(int i3, int i4, @NullableDecl String str) {
        if (i3 < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i3));
        }
        if (i4 >= 0) {
            return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i3), Integer.valueOf(i4));
        }
        throw new IllegalArgumentException("negative size: " + i4);
    }

    private static String badPositionIndexes(int i3, int i4, int i5) {
        return (i3 < 0 || i3 > i5) ? badPositionIndex(i3, i5, "start index") : (i4 < 0 || i4 > i5) ? badPositionIndex(i4, i5, "end index") : Strings.lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(i4), Integer.valueOf(i3));
    }

    public static void checkArgument(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkElementIndex(int i3, int i4) {
        return checkElementIndex(i3, i4, "index");
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2) {
        t2.getClass();
        return t2;
    }

    public static int checkPositionIndex(int i3, int i4) {
        return checkPositionIndex(i3, i4, "index");
    }

    public static void checkPositionIndexes(int i3, int i4, int i5) {
        if (i3 < 0 || i4 < i3 || i4 > i5) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i3, i4, i5));
        }
    }

    public static void checkState(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int checkElementIndex(int i3, int i4, @NullableDecl String str) {
        if (i3 < 0 || i3 >= i4) {
            throw new IndexOutOfBoundsException(badElementIndex(i3, i4, str));
        }
        return i3;
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int checkPositionIndex(int i3, int i4, @NullableDecl String str) {
        if (i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException(badPositionIndex(i3, i4, str));
        }
        return i3;
    }

    public static void checkState(boolean z2, @NullableDecl Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, @NullableDecl Object... objArr) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, objArr));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, @NullableDecl Object... objArr) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, objArr));
    }

    public static void checkState(boolean z2, @NullableDecl String str, @NullableDecl Object... objArr) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, objArr));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, char c3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c3)));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, char c3) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c3)));
    }

    public static void checkState(boolean z2, @NullableDecl String str, char c3) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c3)));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, int i3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i3)));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, int i3) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i3)));
    }

    public static void checkState(boolean z2, @NullableDecl String str, int i3) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i3)));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, long j3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j3)));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, long j3) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j3)));
    }

    public static void checkState(boolean z2, @NullableDecl String str, long j3) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j3)));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, @NullableDecl Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, @NullableDecl Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj));
    }

    public static void checkState(boolean z2, @NullableDecl String str, @NullableDecl Object obj) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, char c3, char c4) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c3), Character.valueOf(c4)));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, char c3, char c4) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c3), Character.valueOf(c4)));
    }

    public static void checkState(boolean z2, @NullableDecl String str, char c3, char c4) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c3), Character.valueOf(c4)));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, char c3, int i3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c3), Integer.valueOf(i3)));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, char c3, int i3) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c3), Integer.valueOf(i3)));
    }

    public static void checkState(boolean z2, @NullableDecl String str, char c3, int i3) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c3), Integer.valueOf(i3)));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, char c3, long j3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c3), Long.valueOf(j3)));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, char c3, long j3) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c3), Long.valueOf(j3)));
    }

    public static void checkState(boolean z2, @NullableDecl String str, char c3, long j3) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c3), Long.valueOf(j3)));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, char c3, @NullableDecl Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c3), obj));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, char c3, @NullableDecl Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c3), obj));
    }

    public static void checkState(boolean z2, @NullableDecl String str, char c3, @NullableDecl Object obj) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c3), obj));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, int i3, char c3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i3), Character.valueOf(c3)));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, int i3, char c3) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i3), Character.valueOf(c3)));
    }

    public static void checkState(boolean z2, @NullableDecl String str, int i3, char c3) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i3), Character.valueOf(c3)));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, int i3, int i4) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i3), Integer.valueOf(i4)));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, int i3, int i4) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i3), Integer.valueOf(i4)));
    }

    public static void checkState(boolean z2, @NullableDecl String str, int i3, int i4) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i3), Integer.valueOf(i4)));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, int i3, long j3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i3), Long.valueOf(j3)));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, int i3, long j3) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i3), Long.valueOf(j3)));
    }

    public static void checkState(boolean z2, @NullableDecl String str, int i3, long j3) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i3), Long.valueOf(j3)));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, int i3, @NullableDecl Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i3), obj));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, int i3, @NullableDecl Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i3), obj));
    }

    public static void checkState(boolean z2, @NullableDecl String str, int i3, @NullableDecl Object obj) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i3), obj));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, long j3, char c3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j3), Character.valueOf(c3)));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, long j3, char c3) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j3), Character.valueOf(c3)));
    }

    public static void checkState(boolean z2, @NullableDecl String str, long j3, char c3) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j3), Character.valueOf(c3)));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, long j3, int i3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j3), Integer.valueOf(i3)));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, long j3, int i3) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j3), Integer.valueOf(i3)));
    }

    public static void checkState(boolean z2, @NullableDecl String str, long j3, int i3) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j3), Integer.valueOf(i3)));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, long j3, long j4) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j3), Long.valueOf(j4)));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, long j3, long j4) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j3), Long.valueOf(j4)));
    }

    public static void checkState(boolean z2, @NullableDecl String str, long j3, long j4) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j3), Long.valueOf(j4)));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, long j3, @NullableDecl Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j3), obj));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, long j3, @NullableDecl Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j3), obj));
    }

    public static void checkState(boolean z2, @NullableDecl String str, long j3, @NullableDecl Object obj) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j3), obj));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, @NullableDecl Object obj, char c3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Character.valueOf(c3)));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, @NullableDecl Object obj, char c3) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Character.valueOf(c3)));
    }

    public static void checkState(boolean z2, @NullableDecl String str, @NullableDecl Object obj, char c3) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Character.valueOf(c3)));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, @NullableDecl Object obj, int i3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Integer.valueOf(i3)));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, @NullableDecl Object obj, int i3) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Integer.valueOf(i3)));
    }

    public static void checkState(boolean z2, @NullableDecl String str, @NullableDecl Object obj, int i3) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Integer.valueOf(i3)));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, @NullableDecl Object obj, long j3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Long.valueOf(j3)));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, @NullableDecl Object obj, long j3) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Long.valueOf(j3)));
    }

    public static void checkState(boolean z2, @NullableDecl String str, @NullableDecl Object obj, long j3) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Long.valueOf(j3)));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2));
    }

    public static void checkState(boolean z2, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3));
    }

    public static void checkState(boolean z2, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void checkArgument(boolean z2, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3, @NullableDecl Object obj4) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }

    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t2, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3, @NullableDecl Object obj4) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
    }

    public static void checkState(boolean z2, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3, @NullableDecl Object obj4) {
        if (!z2) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }
}
