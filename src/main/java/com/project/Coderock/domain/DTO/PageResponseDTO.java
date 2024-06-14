package com.project.Coderock.domain.DTO;

import java.util.List;

public class PageResponseDTO<T> {
    private long totalElements;
    private int totalPages;
    private int size;
    private List<T> content;

    public PageResponseDTO() {
    }

    public PageResponseDTO(long totalElements, int totalPages, int size, List<T> content) {
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.size = size;
        this.content = content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
