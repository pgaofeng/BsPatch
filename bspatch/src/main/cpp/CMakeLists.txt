cmake_minimum_required(VERSION 3.10.2)
project("bspatch")

file(GLOB bzip_sources ${CMAKE_SOURCE_DIR}/bzip2-1.0.6/*.c)

add_library(
        bspatch
        SHARED

        bspatch.c
        bspatch_merge.cpp
        ${bzip_sources}
)


find_library(
        log-lib
        log
)


target_link_libraries(
        bspatch
        ${log-lib}
)