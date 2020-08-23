package com.github.kovaku.producer.service;

import org.springframework.stereotype.Service;

@Service
public class FibonacciService {

    public Long fibRecursive(Integer i) {
        if (i == 0 || i == 1) {
            return i.longValue();
        } else {
            return fibRecursive(i - 1) + fibRecursive(i - 2);
        }
    }

    public Long fibRecursiveWithTempArray(Integer i) {
        return fib(i, new Long[i + 1]);
    }

    public Long fibIterative(Integer i) {
        int ii = 0;
        Long previous, next = 1L, result = 0L;
        while (ii++ < i) {
            previous = next;
            next = result;
            result = previous + next;
        }
        return result;
    }

    private Long fib(Integer i, Long[] intArray) {
        if (intArray[i] == null) {
            if (i == 0 || i == 1) {
                intArray[i] = i.longValue();
            } else {
                intArray[i] = fib(i - 1, intArray) + fib(i - 2, intArray);
            }
        }
        return intArray[i];
    }
}

