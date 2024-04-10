package edu.miu.cs489.ADSApp.service;

import edu.miu.cs489.ADSApp.model.Role;

import java.util.List;

public interface RoleService {
    Role saveRole(Role role);

    List<Role> getAllRoles();

    Role getRoleById(Integer roleId);

    Role updateRole(Role role);

    void deleteRoleById(Integer roleId);
}
