package com.geekbrains.homework4;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import static com.geekbrains.homework4.Functions.*;

public class FunctionsTest {
    @Test
    @DisplayName("Проверка площади прямоугольного треугольника")
    void triangleSquareTest1() {
        assertEquals(triangleSquare(3, 4, 5), 6);
    }

    @Test
    @DisplayName("Проверка площади плоского треугольника")
    void triangleSquareTest2() {
        assertEquals(triangleSquare(4, 4, 0), 0);
    }

    @Test
    @DisplayName("Проверка площади равностороннего треугольника")
    void triangleSquareTest3() {
        assertEquals(triangleSquare(4, 4, 4), Math.sqrt(48));
    }
}
