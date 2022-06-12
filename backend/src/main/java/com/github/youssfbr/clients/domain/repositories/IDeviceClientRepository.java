package com.github.youssfbr.clients.domain.repositories;

import com.github.youssfbr.clients.domain.entities.DeviceClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeviceClientRepository extends JpaRepository<DeviceClient, Long> {
}
