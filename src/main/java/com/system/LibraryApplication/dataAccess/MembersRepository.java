package com.system.LibraryApplication.dataAccess;

import com.system.LibraryApplication.core.entities.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<Members, Long> {
}
