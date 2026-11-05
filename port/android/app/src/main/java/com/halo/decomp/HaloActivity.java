package com.halo.decomp;

import android.app.NativeActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.io.File;

/**
 * HaloActivity principal del puerto de Halo CE para Android.
 * Modificado para soportar Halo CE Custom Edition (mods en files/mods/).
 */
public class HaloActivity extends NativeActivity {

    private static final String TAG = "HaloCECustomEdition";

    // Cargar librerías nativas del motor (según el repositorio original)
    static {
        System.loadLibrary("main");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Mantener la pantalla encendida durante el juego
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        // ==========================================
        // CREACIÓN AUTOMÁTICA DE CARPETAS DE MODS
        // ==========================================
        createModDirectories();
    }

    /**
     * Inicializa la estructura de directorios manteniendo intacta 
     * la carpeta de mapas original y agregando la ruta de mods.
     */
    private void createModDirectories() {
        File baseDir = getExternalFilesDir(null);
        if (baseDir != null) {
            // 1. Carpeta de mapas base oficial (intacta)
            File mapsDir = new File(baseDir, "maps");
            if (!mapsDir.exists()) {
                boolean mapsCreated = mapsDir.mkdirs();
                Log.i(TAG, "Carpeta 'maps' creada: " + mapsCreated);
            }

            // 2. Estructura independiente para los mods del usuario
            File modsDir = new File(baseDir, "mods");
            File modMapsDir = new File(baseDir, "mods/maps");
            File modShadersDir = new File(baseDir, "mods/shaders");
            File modUiDir = new File(baseDir, "mods/UI");
            File modScriptsDir = new File(baseDir, "mods/scripts");

            if (!modsDir.exists()) modsDir.mkdirs();
            if (!modMapsDir.exists()) modsDir.mkdirs();
            if (!modShadersDir.exists()) modsDir.mkdirs();
            if (!modUiDir.exists()) modsDir.mkdirs();
            if (!modScriptsDir.exists()) modsDir.mkdirs();

            Log.i(TAG, "Directorios de Halo CE Custom Edition listos en: " + baseDir.getAbsolutePath());
        } else {
            Log.e(TAG, "Error crítico: No se pudo obtener el almacenamiento externo.");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
