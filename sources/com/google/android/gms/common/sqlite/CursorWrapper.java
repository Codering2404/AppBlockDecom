package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CursorWrapper extends android.database.CursorWrapper implements CrossProcessCursor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AbstractWindowedCursor f72245a;

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int i3, CursorWindow cursorWindow) {
        this.f72245a.fillWindow(i3, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    public CursorWindow getWindow() {
        return this.f72245a.getWindow();
    }

    @Override // android.database.CursorWrapper
    public final /* synthetic */ Cursor getWrappedCursor() {
        return this.f72245a;
    }

    @Override // android.database.CrossProcessCursor
    public final boolean onMove(int i3, int i4) {
        return this.f72245a.onMove(i3, i4);
    }
}
